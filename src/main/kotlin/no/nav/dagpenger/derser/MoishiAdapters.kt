package no.nav.dagpenger.derser

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.math.BigDecimal
import java.net.URI
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter

val moshiInstance: Moshi = Moshi.Builder()
    .add(YearMonthJsonAdapter())
    .add(LocalDateTimeJsonAdapter())
    .add(LocalDateJsonAdapter())
    .add(KotlinJsonAdapterFactory())
    .add(URIJsonAdapter())
    .add(BigDecimalJsonAdapter())
    .build()!!

class URIJsonAdapter {
    @ToJson
    fun toJson(uri: URI): String {
        return uri.toString()
    }

    @FromJson
    fun fromJson(json: String): URI {
        return URI.create(json)
    }
}

class YearMonthJsonAdapter {
    @ToJson
    fun toJson(yearMonth: YearMonth): String {
        return yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"))
    }

    @FromJson
    fun fromJson(json: String): YearMonth {
        return YearMonth.parse(json)
    }
}

class LocalDateJsonAdapter {
    @ToJson
    fun toJson(localDate: LocalDate): String {
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    @FromJson
    fun fromJson(json: String): LocalDate {
        return LocalDate.parse(json)
    }
}

class LocalDateTimeJsonAdapter {
    @ToJson
    fun toJson(localDateTime: LocalDateTime): String {
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    }

    @FromJson
    fun fromJson(json: String): LocalDateTime {
        return LocalDateTime.parse(json)
    }
}

class BigDecimalJsonAdapter {

    @ToJson
    fun toJson(bigDecimal: BigDecimal): String {
        return bigDecimal.toString()
    }

    @FromJson
    fun fromJson(json: String): BigDecimal {
        return BigDecimal(json)
    }
}
