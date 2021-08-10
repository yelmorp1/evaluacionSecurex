exports.listarCajeros = (req,res) => {
    res.send([
        { id:1, nom:"Susan E.", tipoE:"i" , tipoN:"i", tipoAP:"a"	 ,cola:[]},
        { id:2, nom:"Lizbet F.", tipoE:"i" , tipoN:"a", tipoAP:"i"	 ,cola:[]},
        { id:3, nom:"Michael G.", tipoE:"i" , tipoN:"a", tipoAP:"i"  ,cola:[]},
        { id:4, nom:"Alex H.", tipoE:"i" , tipoN:"a", tipoAP:"i"	 ,cola:[]},
        { id:5, nom:"Marco I.", tipoE:"a" , tipoN:"i", tipoAP:"i"	 ,cola:[]},
        { id:6, nom:"Christian J.", tipoE:"i" , tipoN:"i", tipoAP:"i",cola:[]},
        { id:7, nom:"Jean K.", tipoE:"i" , tipoN:"i", tipoAP:"i"	 ,cola:[]},
        { id:8, nom:"Lucas L.", tipoE:"i" , tipoN:"i", tipoAP:"i"	 ,cola:[]}
        ])
}