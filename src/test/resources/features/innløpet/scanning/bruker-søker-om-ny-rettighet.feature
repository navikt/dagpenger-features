# language: no
Egenskap: Bruker søker om ny dagpengeperiode

  Scenariomal: Bruker har ingen sak å gjenoppta
    Gitt at bruker har søkt om dagpenger <rettighetstype>
    Og at bruker ikke har en sak å gjenoppta
    Og at bruker har diskresjonskode <diskresjonskode>
    Når vi behandler journalføringen
    Så opprettes fagsak
    Og ny gsak knyttes til fagsak
    Og journalpost knyttes til gsak
    Og journalpost ferdigstilles
    Og oppgave "Start Vedtaksbehandling" opprettes på <benk>

    Eksempler:
      | rettighetstype    | diskresjonskode | benk |
      | uten permittering | ikke            | 4450 |
      | ved permittering  | ikke            | 4455 |
      | uten permittering | 6, 7            | 4499 |
      | ved permittering  | 6, 7            | 4499 |

  Scenario: Bruker har søkt, men har allerede en aktiv sak
    Gitt at bruker har søkt
    Og bruker har en aktiv sak
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys

  Scenario: Bruker finnes ikke i Arena
    Gitt at bruker har søkt
    Og bruker ikke finnes i Arena
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys

  Scenario: Bruker mangler kontortilhørighet
    Gitt at bruker har søkt
    Og bruker mangler kontortilhørighet
    Når vi behandler journalføringen
    Så opprettes det en manuell journalføringsoppgave i Gosys
