package module.statistics;

import core.gui.theme.HOColorName;
import core.gui.theme.ThemeManager;

import java.awt.*;

// reference to HOColorName.PALETTE15
public final class Colors {

    public static final int COLOR_PLAYER_FORM = 0;
    public static final int COLOR_PLAYER_STAMINA = 1;
    public static final int COLOR_PLAYER_LOYALTY = 2;
    public static final int COLOR_PLAYER_GK = 3;
    public static final int COLOR_PLAYER_DE = 4;
    public static final int COLOR_PLAYER_PM = 5;
    public static final int COLOR_PLAYER_PS = 6;
    public static final int COLOR_PLAYER_WI = 7;
    public static final int COLOR_PLAYER_SC = 8;
    public static final int COLOR_PLAYER_SP = 9;
    public static final int COLOR_PLAYER_LEADERSHIP = 10;
    public static final int COLOR_PLAYER_XP = 11;
    public static final int COLOR_PLAYER_RATING = 12;
    public static final int COLOR_PLAYER_TSI = 0;
    public static final int COLOR_PLAYER_WAGE = 1;

    public static final int COLOR_TEAM_RATING = 0;
    public static final int COLOR_TEAM_HATSTATS = 1;
    public static final int COLOR_TEAM_LODDAR = 2;
    public static final int COLOR_TEAM_TOTAL_STRENGTH = 3;
    public static final int COLOR_TEAM_MID = 4;
    public static final int COLOR_TEAM_RD = 5;
    public static final int COLOR_TEAM_CD = 6;
    public static final int COLOR_TEAM_LD = 7;
    public static final int COLOR_TEAM_RA = 8;
    public static final int COLOR_TEAM_CA = 9;
    public static final int COLOR_TEAM_LA = 10;
    public static final int COLOR_TEAM_TS = 11;
    public static final int COLOR_TEAM_CONFIDENCE = 12;

    public static final int COLOR_FINANCE_CASH = 0;
    public static final int COLOR_FINANCE_INCOME_SPONSORS =1;
    public static final int COLOR_FINANCE_COST_PLAYERS = 2;

    public static final int COLOR_CLUB_ASSISTANT_TRAINERS_LEVEL = 0;
    public static final int COLOR_CLUB_FINANCIAL_DIRECTORS_LEVEL = 1;
    public static final int COLOR_CLUB_FORM_COACHS_LEVEL= 2;
    public static final int COLOR_CLUB_DOCTORS_LEVEL = 3;
    public static final int COLOR_CLUB_SPOKE_PERSONS_LEVEL = 4;
    public static final int COLOR_CLUB_SPORT_PSYCHOLOGIST_LEVELS = 5;
    public static final int COLOR_CLUB_TACTICAL_ASSISTANT_LEVELS = 6;
    public static final int COLOR_CLUB_FAN_CLUB_SIZE = 7;
    public static final int COLOR_CLUB_GLOBAL_RANKING = 8;
    public static final int COLOR_CLUB_LEAGUE_RANKING = 9;
    public static final int COLOR_CLUB_POWER_RATING = 10;

    public static Color getColor(int i) {return ThemeManager.getColor(HOColorName.PALETTE13[i]);}

}
