package local.heftyb.countries.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country
{
    // countryid, name, population, landmasskm2, medianage

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long countryid;
    String name;
    int population;
    int landmasskm2;
    int medianage;

    public Country(
        String name,
        int population,
        int landmasskm2,
        int medianage)
    {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public Country()
    {
    }

    public long getCountryid()
    {
        return countryid;
    }

    public void setCountryid(long countryid)
    {
        this.countryid = countryid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandmasskm2()
    {
        return landmasskm2;
    }

    public void setLandmasskm2(int landmasskm2)
    {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage()
    {
        return medianage;
    }

    public void setMedianage(int medianage)
    {
        this.medianage = medianage;
    }

    @Override
    public String toString()
    {
        return "Company{" +
            "countryid=" + countryid +
            ", name='" + name + '\'' +
            ", population=" + population +
            ", landmasskm2=" + landmasskm2 +
            ", medianage=" + medianage +
            '}';
    }
}
