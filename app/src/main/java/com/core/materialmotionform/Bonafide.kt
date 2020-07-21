package com.core.materialmotionform

data class Bonafide(
    val id : Int?,
    val status : Boolean?,
    val appliedDate : String?,
    val subject : String?,
    val reasonInDetail : String?
)

val bonafide1 = Bonafide(
    id = 1,
    status = false,
    appliedDate = "10 July 2020",
    subject = "Regarding EBC account",
    reasonInDetail = "I have to open a saving bank account for EBC in SBI bank. for this i need to submit my bonafide certificate"
)

val bonafide2 = Bonafide(
    id = 2,
    status = true,
    appliedDate = "06 Jun 2020",
    subject = "Monthly travel pass",
    reasonInDetail = "I am traveling daily with MSRTC bus and i need bonafide certificate to obtain my monthly pass"
)

val bonafide3 = Bonafide(
    id = 3,
    status = false,
    appliedDate = "28 Jun 2020",
    subject = "To join a public library",
    reasonInDetail = "I am joining public library for my external project, for joining library i need to submit my education details with bonafide certificate."
)

val bonafide4 = Bonafide(
    id = 4,
    status = true,
    appliedDate = "12 Jun 2020",
    subject = "Regarding education loan",
    reasonInDetail = "Recently i have applied for education loan in SBI bank and submitted all other documents but the need my bonafide certificate for further process."
)

val bonafide5 = Bonafide(
    id = 5,
    status = false,
    appliedDate = "12 Jun 2020",
    subject = "Passport verification",
    reasonInDetail = "I need my bonafide certificate by the institute for passport application purpose."
)

val bonafides = arrayListOf(bonafide1, bonafide2, bonafide3, bonafide4, bonafide5)