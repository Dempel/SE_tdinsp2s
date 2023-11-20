package org.hbrs.se1.ws23.uebung4.UserStory;

import java.io.Serializable;

public class UserStory implements Serializable {
        // ToDo: Sind die Attribute der Klasse UserStory vollständig? (F4)

        String titel;
        String akzeptanzkriterium;
        int aufwand = 0;
        int id = 0;
        int mehrwert = 0;
        int risk = 0;
        int strafe = 0;
        double prio = 0.0;
        String project;

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public UserStory() {}


        public UserStory(int id, String titel, String akzeptanzkriterium, int mehrwert, int strafe,
                         int aufwand, int risk, double prio) {
            this.id = id;
            this.titel = titel;
            this.akzeptanzkriterium = akzeptanzkriterium;
            this.mehrwert = mehrwert;
            this.strafe = strafe;
            this.aufwand = aufwand;
            this.risk = risk;
            this.prio = prio;
        }


        public double getPrio() {
            return prio;
        }

        public void setPrio(double prio) {
            this.prio = prio;
        }

        public String getTitel() {
            return titel;
        }
        public void setTitel(String titel) {
            this.titel = titel;
        }
        public String getAkzeptanzkriterium() {
            return akzeptanzkriterium;
        }
        public void setAkzeptanzkriterium(String akzeptanzkriterium) {
            this.akzeptanzkriterium = akzeptanzkriterium;
        }
        public int getAufwand() {
            return aufwand;
        }
        public void setAufwand(int aufwand) {
            this.aufwand = aufwand;
        }
        public int getid() {
            return id;
        }
        public void setID(int id) {
            this.id = id;
        }
        public int getMehrwert() {
            return mehrwert;
        }
        public void setMehrwert(int mehrwert) {
            this.mehrwert = mehrwert;
        }
        public int getRisk() {
            return risk;
        }
        public void setRisk(int risk) {
            this.risk = risk;
        }
        public int getStrafe() {
            return strafe;
        }
        public void setStrafe(int strafe) {
            this.strafe = strafe;
        }

        @Override
        public String toString() {
            return "ID: " + id + "\t" +
                    "Beschreibung: " + titel + "\t" +
                    "Akteptanzkriterium: " + akzeptanzkriterium + "\t" +
                    "Mehrwert: " + mehrwert + "\t" +
                    "Strafe: " + strafe + "\t" +
                    "Aufwand: " + aufwand + "\t" +
                    "Risiko: " + risk + "\t" +
                    "Priorität: " + prio +"\t" +
                    "Projekt: " + project;
        }
    }

