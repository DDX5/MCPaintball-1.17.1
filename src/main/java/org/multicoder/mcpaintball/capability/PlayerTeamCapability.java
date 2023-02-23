package org.multicoder.mcpaintball.capability;

import net.minecraft.nbt.CompoundTag;

public class PlayerTeamCapability
{
    private int Team;
    private int Points;

    public int GetTeam(){
        return Team;
    }
    public void SetTeam(int t)
    {
        Team = t;
    }
    public int GetPoints(){
        return Points;
    }
    public void IncPoints()
    {
        Points += 1;
    }

    public void DecPoints(){Points -= 1;}
    public void SetPoints(int P){
        Points = P;
    }
    public void ResetPoints(){
        Points = 0;
    }
    public void ResetAll(){
        Team = 0;
        Points = 0;
    }
    public void Sync()
    {
    }
    public void CopyFrom(PlayerTeamCapability source)
    {
        this.Team = source.GetTeam();
        this.Points = source.GetPoints();
    }

    public void saveNBT(CompoundTag tag)
    {
        tag.putInt("Team",Team);
        tag.putInt("Points",Points);
    }

    public void readNBT(CompoundTag tag)
    {
        this.SetTeam(tag.getInt("Team"));
        this.SetPoints(tag.getInt("Points"));
    }
}
