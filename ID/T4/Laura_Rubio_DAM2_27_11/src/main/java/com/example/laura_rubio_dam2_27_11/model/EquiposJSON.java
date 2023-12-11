package com.example.laura_rubio_dam2_27_11.model;

public class EquiposJSON {
    String strTeam; //nombreequipo
    String strTeamBadge ; //imagen
    String strLeague; //nombre liga
    String strStadiumDescription; //descripcion

    public EquiposJSON() {
    }

    public EquiposJSON(String strTeam) {
        this.strTeam = strTeam;
    }


    @Override
    public String toString() {
        return strTeam;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }
}
