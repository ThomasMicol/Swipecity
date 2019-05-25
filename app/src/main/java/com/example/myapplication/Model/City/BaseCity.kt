class BaseCity : ICity
{
    var populationController : IPopulationController
    var buildingController : IBuildingController
    var infrastructureController : IInfrastructureController
    var businessController : IBusinessController
    var economyController : IEconomyController
    var neighbouringCity : List<ISimulatedCity> 

    fun constructor(repo = null : IPersistanceProvider?, options GameOptions)
    {
        if(repo == null)
        {
            var newCityFactory = NewGameCityFactory()
            this.populationController = newCityFactory.GetPopulationController()
            this.buildingController = newCityFactory.GetBuildingController()
            this.infrastructureController = newCityFactory.GetinfrastructureController()
            this.businessController = newCityFactory.GetbusinessController()
            this.economyController = newCityFactory.GetEconomyController()
            this.neighbouringCitiesController = newCityFactory.GetNeighbouringCitiesController()
        }
    }
        
}