package ng.etokakingsley.cowrywise_converter.network.response


import com.google.gson.annotations.SerializedName
import ng.etokakingsley.cowrywise_converter.model.LocalRate

data class NetworkRate(
    @SerializedName("AED")
    val AED: Double =0.0,
    @SerializedName("AFN")
    val AFN: Double = 0.0,
    @SerializedName("ALL")
    val ALL: Double = 0.0,
    @SerializedName("AMD")
    val AMD: Double= 0.0,
    @SerializedName("ANG")
    val ANG: Double =0.0,
    @SerializedName("AOA")
    val AOA: Double=0.0,
    @SerializedName("ARS")
    val ARS: Double=0.0,
    @SerializedName("AUD")
    val AUD: Double=0.0,
    @SerializedName("AWG")
    val AWG: Double=0.0,
    @SerializedName("AZN")
    val AZN: Double=0.0,
    @SerializedName("BAM")
    val BAM: Double=0.0,
    @SerializedName("BBD")
    val BBD: Double=0.0,
    @SerializedName("BDT")
    val BDT: Double=0.0,
    @SerializedName("BGN")
    val BGN: Double=0.0,
    @SerializedName("BHD")
    val BHD: Double=0.0,
    @SerializedName("BIF")
    val BIF: Double=0.0,
    @SerializedName("BMD")
    val BMD: Double=0.0,
    @SerializedName("BND")
    val BND: Double=0.0,
    @SerializedName("BOB")
    val BOB: Double =0.0,
    @SerializedName("BRL")
    val BRL: Double =0.0,
    @SerializedName("BSD")
    val BSD: Double=0.0,
    @SerializedName("BTC")
    val BTC: Double=0.0,
    @SerializedName("BTN")
    val BTN: Double=0.0,
    @SerializedName("BWP")
    val BWP: Double=0.0,
    @SerializedName("BYN")
    val BYN: Double=0.0,
    @SerializedName("BYR")
    val BYR: Double=0.0,
    @SerializedName("BZD")
    val BZD: Double=0.0,
    @SerializedName("CAD")
    val CAD: Double=0.0,
    @SerializedName("CDF")
    val CDF: Double=0.0,
    @SerializedName("CHF")
    val CHF: Double=0.0,
    @SerializedName("CLF")
    val CLF: Double=0.0,
    @SerializedName("CLP")
    val CLP: Double=0.0,
    @SerializedName("CNY")
    val CNY: Double=0.0,
    @SerializedName("COP")
    val COP: Double=0.0,
    @SerializedName("CRC")
    val CRC: Double=0.0,
    @SerializedName("CUC")
    val CUC: Double=0.0,
    @SerializedName("CUP")
    val CUP: Double=0.0,
    @SerializedName("CVE")
    val CVE: Double=0.0,
    @SerializedName("CZK")
    val CZK: Double=0.0,
    @SerializedName("DJF")
    val DJF: Double=0.0,
    @SerializedName("DKK")
    val DKK: Double=0.0,
    @SerializedName("DOP")
    val DOP: Double=0.0,
    @SerializedName("DZD")
    val DZD: Double=0.0,
    @SerializedName("EGP")
    val eGP: Double=0.0,
    @SerializedName("ERN")
    val eRN: Double,
    @SerializedName("ETB")
    val eTB: Double,
    @SerializedName("EUR")
    val eUR: Int,
    @SerializedName("FJD")
    val fJD: Double,
    @SerializedName("FKP")
    val fKP: Double,
    @SerializedName("GBP")
    val gBP: Double,
    @SerializedName("GEL")
    val gEL: Double,
    @SerializedName("GGP")
    val gGP: Double,
    @SerializedName("GHS")
    val gHS: Double,
    @SerializedName("GIP")
    val gIP: Double,
    @SerializedName("GMD")
    val gMD: Double,
    @SerializedName("GNF")
    val gNF: Double,
    @SerializedName("GTQ")
    val gTQ: Double,
    @SerializedName("GYD")
    val gYD: Double,
    @SerializedName("HKD")
    val hKD: Double,
    @SerializedName("HNL")
    val hNL: Double,
    @SerializedName("HRK")
    val hRK: Double,
    @SerializedName("HTG")
    val hTG: Double,
    @SerializedName("HUF")
    val hUF: Double,
    @SerializedName("IDR")
    val iDR: Double,
    @SerializedName("ILS")
    val iLS: Double,
    @SerializedName("IMP")
    val iMP: Double,
    @SerializedName("INR")
    val iNR: Double,
    @SerializedName("IQD")
    val iQD: Double,
    @SerializedName("IRR")
    val iRR: Double,
    @SerializedName("ISK")
    val iSK: Double,
    @SerializedName("JEP")
    val jEP: Double,
    @SerializedName("JMD")
    val jMD: Double,
    @SerializedName("JOD")
    val jOD: Double,
    @SerializedName("JPY")
    val jPY: Double,
    @SerializedName("KES")
    val kES: Double,
    @SerializedName("KGS")
    val kGS: Double,
    @SerializedName("KHR")
    val kHR: Double,
    @SerializedName("KMF")
    val kMF: Double,
    @SerializedName("KPW")
    val kPW: Double,
    @SerializedName("KRW")
    val kRW: Double,
    @SerializedName("KWD")
    val kWD: Double,
    @SerializedName("KYD")
    val kYD: Double,
    @SerializedName("KZT")
    val kZT: Double,
    @SerializedName("LAK")
    val lAK: Double,
    @SerializedName("LBP")
    val lBP: Double,
    @SerializedName("LKR")
    val lKR: Double,
    @SerializedName("LRD")
    val lRD: Double,
    @SerializedName("LSL")
    val lSL: Double,
    @SerializedName("LTL")
    val lTL: Double,
    @SerializedName("LVL")
    val lVL: Double,
    @SerializedName("LYD")
    val lYD: Double,
    @SerializedName("MAD")
    val mAD: Double,
    @SerializedName("MDL")
    val mDL: Double,
    @SerializedName("MGA")
    val mGA: Double,
    @SerializedName("MKD")
    val mKD: Double,
    @SerializedName("MMK")
    val mMK: Double,
    @SerializedName("MNT")
    val mNT: Double,
    @SerializedName("MOP")
    val mOP: Double,
    @SerializedName("MRO")
    val mRO: Double,
    @SerializedName("MUR")
    val mUR: Double,
    @SerializedName("MVR")
    val mVR: Double,
    @SerializedName("MWK")
    val mWK: Double,
    @SerializedName("MXN")
    val mXN: Double,
    @SerializedName("MYR")
    val mYR: Double,
    @SerializedName("MZN")
    val mZN: Double,
    @SerializedName("NAD")
    val nAD: Double,
    @SerializedName("NGN")
    val nGN: Double,
    @SerializedName("NIO")
    val nIO: Double,
    @SerializedName("NOK")
    val nOK: Double,
    @SerializedName("NPR")
    val nPR: Double,
    @SerializedName("NZD")
    val nZD: Double,
    @SerializedName("OMR")
    val oMR: Double,
    @SerializedName("PAB")
    val pAB: Double,
    @SerializedName("PEN")
    val pEN: Double,
    @SerializedName("PGK")
    val pGK: Double,
    @SerializedName("PHP")
    val pHP: Double,
    @SerializedName("PKR")
    val pKR: Double,
    @SerializedName("PLN")
    val pLN: Double,
    @SerializedName("PYG")
    val pYG: Double,
    @SerializedName("QAR")
    val qAR: Double,
    @SerializedName("RON")
    val rON: Double,
    @SerializedName("RSD")
    val rSD: Double,
    @SerializedName("RUB")
    val rUB: Double,
    @SerializedName("RWF")
    val rWF: Double,
    @SerializedName("SAR")
    val sAR: Double,
    @SerializedName("SBD")
    val sBD: Double,
    @SerializedName("SCR")
    val sCR: Double,
    @SerializedName("SDG")
    val sDG: Double,
    @SerializedName("SEK")
    val sEK: Double,
    @SerializedName("SGD")
    val sGD: Double,
    @SerializedName("SHP")
    val sHP: Double,
    @SerializedName("SLL")
    val sLL: Double,
    @SerializedName("SOS")
    val sOS: Double,
    @SerializedName("SRD")
    val sRD: Double,
    @SerializedName("STD")
    val sTD: Double,
    @SerializedName("SVC")
    val sVC: Double,
    @SerializedName("SYP")
    val sYP: Double,
    @SerializedName("SZL")
    val sZL: Double,
    @SerializedName("THB")
    val tHB: Double,
    @SerializedName("TJS")
    val tJS: Double,
    @SerializedName("TMT")
    val tMT: Double,
    @SerializedName("TND")
    val tND: Double,
    @SerializedName("TOP")
    val tOP: Double,
    @SerializedName("TRY")
    val tRY: Double,
    @SerializedName("TTD")
    val tTD: Double,
    @SerializedName("TWD")
    val tWD: Double,
    @SerializedName("TZS")
    val tZS: Double,
    @SerializedName("UAH")
    val uAH: Double,
    @SerializedName("UGX")
    val uGX: Double,
    @SerializedName("USD")
    val USD: Double=0.0,
    @SerializedName("UYU")
    val UYU: Double=0.0,
    @SerializedName("UZS")
    val UZS: Double=0.0,
    @SerializedName("VEF")
    val VEF: Double=0.0,
    @SerializedName("VND")
    val VND: Double=0.0,
    @SerializedName("VUV")
    val VUV: Double=0.0,
    @SerializedName("WST")
    val WST: Double=0.0,
    @SerializedName("XAF")
    val XAF: Double=0.0,
    @SerializedName("XAG")
    val XAG: Double=0.0,
    @SerializedName("XAU")
    val XAU: Double=0.0,
    @SerializedName("XCD")
    val XCD: Double=0.0,
    @SerializedName("XDR")
    val XDR: Double=0.0,
    @SerializedName("XOF")
    val XOF: Double=0.0,
    @SerializedName("XPF")
    val XPF: Double=0.0,
    @SerializedName("YER")
    val YER: Double=0.0,
    @SerializedName("ZAR")
    val ZAR: Double=0.0,
    @SerializedName("ZMK")
    val ZMK: Double=0.0,
    @SerializedName("ZMW")
    val ZMW: Double=0.0,
    @SerializedName("ZWL")
    val ZWL: Double=0.0
)