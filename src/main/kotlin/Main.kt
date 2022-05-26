import java.util.*

fun main(){
    println("Tech -> ${PaymentFacade().getDepartmentHours(Department.TECH)}")
    println("Tech -> ${PaymentFacade().getDepartmentHours(Department.ADMINISTRATION)}")
    println("Tech -> ${PaymentFacade().getDepartmentHours(Department.HUMAN_RESOURCES)}")

}

class PaymentFacade(){

    fun getDepartmentHours(department: Department): MainHourCalculationInterface{
        return when(department){
            Department.TECH -> TechHoursCalculation().hourCalculation() as TechHourCalculation
            Department.ADMINISTRATION -> AdministrationHoursCalculation().hourCalculation() as AdministrationHourCalculation
            Department.HUMAN_RESOURCES -> HumanResourcesHoursCalculation().hourCalculation() as HumanResourcesHourCalculation
        }
    }
}

interface MainHourCalculationInterface {
    val time: Int
}

data class HumanResourcesHourCalculation(
    override val time: Int
) : MainHourCalculationInterface

data class TechHourCalculation(
    override val time: Int,
    val name: String
): MainHourCalculationInterface

data class AdministrationHourCalculation(
    override val time: Int,
    val date: Date,
    val decision: Boolean
    ): MainHourCalculationInterface

interface HoursCalculationInterface {

    fun hourCalculation(): MainHourCalculationInterface

}

class HumanResourcesHoursCalculation(): HoursCalculationInterface {

    override fun hourCalculation(): MainHourCalculationInterface{
        return HumanResourcesHourCalculation(
            time = 1
        )
    }
}

class TechHoursCalculation(): HoursCalculationInterface {
    override fun hourCalculation(): MainHourCalculationInterface{
        return TechHourCalculation(
            time = 2,
            name = "sergio"
        )
    }
}

class AdministrationHoursCalculation(): HoursCalculationInterface {
    override fun hourCalculation(): MainHourCalculationInterface{
        return AdministrationHourCalculation(
            time = 3,
            date = Date(),
            decision = true
        )
    }
}

enum class Department {
    TECH,
    ADMINISTRATION,
    HUMAN_RESOURCES
}

