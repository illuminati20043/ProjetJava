package org.example;

/**
 * L'énumération TypeHero représente différents types de héros avec leurs points de vie (pv), leur défense et leur force d'attaque.
 */
public enum TypeHero {
        Tank(200, 20, "Regénération"),
        Damage(40, 10, "Demacian Justice"),
        Archer(80, 5, "Karthus Ult");

        private final int pv; // Points de vie du héros
        private final float defense; // Défense du héros
        private final String forceAttaque; // Force d'attaque du héros

        /**
         * Constructeur de l'énumération TypeHero.
         *
         * @param pv          Points de vie du héros.
         * @param defense     Défense du héros.
         * @param forceAttaque Force d'attaque du héros.
         */
        TypeHero(int pv, float defense, String forceAttaque) {
                this.pv = pv;
                this.defense = defense;
                this.forceAttaque = forceAttaque;
        }

        /**
         * Retourne les points de vie du héros.
         *
         * @return Points de vie du héros.
         */
        public int getPv() {
                return pv;
        }

        /**
         * Retourne la défense du héros.
         *
         * @return Défense du héros.
         */
        public float getDefense() {
                return defense;
        }

        /**
         * Retourne la force d'attaque du héros.
         *
         * @return Force d'attaque du héros.
         */
        public String getForceAttaque() {
                return forceAttaque;
        }
}