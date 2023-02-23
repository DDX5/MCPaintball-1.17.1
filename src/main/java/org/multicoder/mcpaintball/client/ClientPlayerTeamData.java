package org.multicoder.mcpaintball.client;

public class ClientPlayerTeamData
{
    private static int Points;
    private static int Team;

    public static void SetPoints(int P)
    {
        ClientPlayerTeamData.Points = P;
    }
    public static void SetTeam(int T)
    {
        ClientPlayerTeamData.Team = T;
    }

    public static int GetPoints(){
        return Points;
    }
    public static int GetTeam(){
        return Team;
    }
}
