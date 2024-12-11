package tavolaelementi;

public enum EnumElementi {
    H("Idrogeno",1.008,1),
    He("Elio",4.003,2),
    Li("Litio",6.94,3),
    Be("Berillio",9.012,4),
    B("Boro",10.81,5),
    C("Carbonio",12.01,6),
    N("Azoto",14.01,7),
    O("Ossigeno",16.00,8),
    F("Fluoro",19.00,9),
    Ne("Neon",20.18,10),
    Na("Sodio",22.99,11),
    Mg("Magnesio",24.31,12),
    Al("Alluminio",26.98,13),
    Si("Silicio",28.09,14),
    P("Fosforo",30.97,15),
    S("Zolfo",32.06,16),
    Cl("Cloro",35.45,17),
    Ar("Argon",39.95,18),
    K("Potassio",39.01,19),
    Ca("Calcio",40.08,20),
    Sc("Scandio",44.96,21),
    Ti("Titanio",47.87,22),
    V("Vanadio",50.94,23),
    Cr("Cromo",52,24),
    Mn("Manganese",54.94,25),
    Fe("Ferro",55.85,26),
    Co("Cobalto",58.93,27),
    Ni("Nichel",58.69,28),
    Cu("Rame",63.55,29),
    Zn("Zinco",65.37,30),
    Ga("Gallio",69.72,31),
    Ge("Germanio",72.64,32),
    As("Arsenico",74.92,33),
    Se("Selenio",78.96,34),
    Br("Bromo",79.91,35),
    Kr("Kripton",83.80,36),
    Rb("Rubidio",85.47,37),
    Sr("Stronzio",87.62,38),
    Y("Ittrio",88.91,39),
    Zr("Zirconio",91.22,40),
    Nb("Niobio",92.91,41),
    Mo("Molibdeno",95.94,42),
    Tc("Tecnezio",98.91,43),
    Ru("Rutenio",101.10,44),
    Rh("Rodio",102.90,45),
    Pd("Palladio",106.40,46),
    Ag("Argento",107.90,47),
    Cd("Cadmio",112.40,48),
    In("Indio",114.80,49),
    Sn("Stagno",118.70,50),
    Sb("Antimonio",121.80,51),
    Te("Tellurio",127.60,52),
    I("Iodio",126.90,53),
    Xe("Xeno",131.30,54),
    Cs("Cesio",132.90,55);/*
    Ba("Bario",,),
    La("Lantanio",,),
    Ce("Cerio",,),
    Pr("Praseodimio",,),
    Nd("Neodimio",,),
    Pm("Promezio",,),
    Sm("Samario",,),
    Eu("Europio",,),
    Gd("Gadolinio",,),
    Tb("Terbio",,),
    Dy("Disprosio",,),
    Ho("Olmio",,),
    Er("Erbio",,),
    Tm("Tulio",,),
    Yb("Itterbio",,),
    Lu("Lutezio",,),
    Hf("Afnio",,),
    Ta("Tantalio",,),
    W("Tungsteno",,),
    Re("Renio",,),
    Os("Osmio",,),
    Ir("Iridio",,),
    Pt("Platino",,),
    Au("Oro",,),
    Hg("Mercurio",,),
    Tl("Tallio",,),
    Pb("Piombo",,),
    Bi("Bismuto",,),
    Po("Polonio",,),
    At("Astato",,),
    Rn("Radion",,),
    Fr("Francio",,),
    Ra("Radio",,),
    Ac("Attinio",,),
    Th("Torio",,),
    Pa("Protoattinio",,),
    U("Uranio",,),
    Np("Nettunio",,),
    Pu("Plutonio",,),
    Am("Americio",,),
    Cm("Curio",,),
    Bk("Berkelio",,),
    Cf("Californio",,),
    Es("Einstenio",,),
    Fm("Fermio",,),
    Md("Mendelevio",,),
    No("Nobelio",,),
    Lr("Laurenzio",,),
    Rf("Rutherfodio",,),
    Db("Dubnio",,),
    Sg("Seaborgio",,),
    Bh("Bohrio",,),
    Hs("Hassio",,),
    Mt("Meitnerio",,),
    Ds("Darmstadio",,),
    Rg("",,),
    Cn("",,),
    Uut("",,),
    Fl("",,),
    Uup("",,),
    Lv("",,),
    Uus("",,),
    Uuo("",,);*/
    
    
    private String nameElement;
    private double massaAtomica;
    private int numeroAtomico;
    
    private EnumElementi(String sName, double dMassaAtomica, int iZ){
        this.nameElement = sName;
        this.massaAtomica = dMassaAtomica;
        this.numeroAtomico = iZ;
    }
   
    public void printElements(){
        for(EnumElementi iter : EnumElementi.values()){
            System.out.println("Sigla Elemento: " + iter.name() + " \n\tNome Completo: " + iter.getNameElement() + " Numero Atomico: " + iter.getNumeroAtomico() + " Massa Atomica: " + iter.getMassaAtomica());
        }
    }    

    /**
     * @return the nameElement
     */
    public String getNameElement() {
        return nameElement;
    }

    /**
     * @param nameElement the nameElement to set
     */
    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    /**
     * @return the massaAtomica
     */
    public double getMassaAtomica() {
        return massaAtomica;
    }

    /**
     * @param massaAtomica the massaAtomica to set
     */
    public void setMassaAtomica(double massaAtomica) {
        this.massaAtomica = massaAtomica;
    }

    /**
     * @return the numeroAtomico
     */
    public int getNumeroAtomico() {
        return numeroAtomico;
    }

    /**
     * @param numeroAtomico the numeroAtomico to set
     */
    public void setNumeroAtomico(int numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }
}
