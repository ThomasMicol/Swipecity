class PolicyViewComponent : IViewComponent
{
    lateinit var policy: IPolicy

    override constructor(context: R, data){
        this.context = context
    }

    override fun SetComponentData(data){
        this.policy = data;
    }

    override fun Draw()
    {

    }
}