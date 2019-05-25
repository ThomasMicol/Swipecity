class NewGameCityFactory
{
    var _repo : IPersistanceProvider

    fun constructor(repo: IPersistanceProvider)
    {
        
    }

    fun GetPopulationController()
    {
        return BasePopulationController()
    }

    fun GetBuildingController()
    {
        return BaseBuildingController()
    }

    fun GetInfrastructureController()
    {
        return BaseInfrastructureController()
    }

    fun GetBusinessController()
    {
        return BaseBusinessController()
    }

    fun GetEconomyController()
    {
        return BaseEconomyController()
    }

    fun GetNeighbouringCitiesController()
    {
        return BaseNeightbouringCitiesController()
    }
}