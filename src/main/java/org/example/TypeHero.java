package org.example;

public enum TypeHero {
    
        Tank(200,20,"Bouclier"),
        Damage(100,10,"Epee"),
        Archer(80,5,"Arc");
        private final int pv;
        private final float defense;
        private final String forceAttaque;

        TypeHero(int pv, float defense, String forceAttaque) {
                this.pv = pv;
                this.defense = defense;
                this.forceAttaque = forceAttaque;
        }

        public int getPv() {
                return pv;
        }

        public float getDefense() {
                return defense;
        }

        public String getForceAttaque() {
                return forceAttaque;
        }

}


