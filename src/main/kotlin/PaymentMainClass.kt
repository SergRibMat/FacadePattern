fun main(){

    val request = Request("This is a stringified json response from a bank android application")
    val mitResponse = PaymentMethodRequester(request).getPaymentResponseForType(PaymentType.MIT)
    val payaResponse = PaymentMethodRequester(request).getPaymentResponseForType(PaymentType.PAYA)
    val ecopaynetResponse = PaymentMethodRequester(request).getPaymentResponseForType(PaymentType.ECOPAYNET)
    println("response from MIT -> $mitResponse")
    println("response from PAYA -> $payaResponse")
    println("response from ECOPAYNET -> $ecopaynetResponse")

}

enum class PaymentType {
    MIT,
    PAYA,
    ECOPAYNET
}

data class Request(
    val request: String
)

interface ResponseImpl {
    //I just wanted to have a variable here
    val success: Boolean
}

class PaymentMethodRequester(private val request: Request) {

    //you can add any action here!! transformation from string to object and from object to String, for example

    fun getPaymentResponseForType(paymentType: PaymentType): ResponseImpl{
        //here, you migh be able to return an intent object with its extra key-value data!!
        return when(paymentType){
                PaymentType.MIT ->{
                    MitPaymentType(request).createResponse()
                }
                PaymentType.PAYA ->{
                    PayaPaymentType(request).createResponse()
                }
                PaymentType.ECOPAYNET ->{
                    EcopaynetPaymentType(request).createResponse()
                }

        }
    }

    fun getPaymentRequestForType(){

    }

}

interface PaymentResponseImpl{
    fun createResponse(): ResponseImpl
}

class MitPaymentType(request: Request): PaymentResponseImpl{

    override fun createResponse(): Response{
        //simulo que uso la request
        return Response(
            true,
            "this is a stringified json",

        )
    }

    data class Response(
        override val success: Boolean,
        val response: String
    ) : ResponseImpl
}

class PayaPaymentType(request: Request): PaymentResponseImpl{

    override fun createResponse(): Response{
        //simulo que uso la request
        return Response(
            true,
            "11223344",
            "20/05/2022T20:00:00.000Z"

        )
    }

    data class Response(
        override val success: Boolean,
        val reference: String,
        val dateTime: String
    ) : ResponseImpl

}

class EcopaynetPaymentType(request: Request): PaymentResponseImpl{

    override fun createResponse(): Response{
        //imagine i do some operations with the request value
        return Response(
            true,
            "20/05/2022T20:00:00.000Z",
            "12345678"
        )
    }

    data class Response(
        override val success: Boolean,
        val dateTime: String,
        val bankNumber: String
    ) : ResponseImpl
}