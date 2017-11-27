package Model;

public class Pet 
{
    private String userid;
    private int animaltypeid;
    private String petname;
    private boolean vaccinated;
    private int photoid;
    private String status_pet;

    public Pet(String userid, int animaltypeid, String petname, boolean vaccinated, int photoid, String status_pet) 
    {
        this.userid = userid;
        this.animaltypeid = animaltypeid;
        this.petname = petname;
        this.vaccinated = vaccinated;
        this.photoid = photoid;
        this.status_pet = status_pet;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getAnimaltypeid() {
        return animaltypeid;
    }

    public void setAnimaltypeid(int animaltypeid) {
        this.animaltypeid = animaltypeid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getStatus_pet() {
        return status_pet;
    }

    public void setStatus_pet(String status_pet) {
        this.status_pet = status_pet;
    }
    
    
    
}
