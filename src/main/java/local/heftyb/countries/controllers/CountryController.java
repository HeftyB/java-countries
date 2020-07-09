package local.heftyb.countries.controllers;

import local.heftyb.countries.models.Country;
import local.heftyb.countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{

    @Autowired
    CountryRepository comprepo;

    private List<Country> findCountries (List<Country> myList, CheckCountry datest)
    {
        List<Country> tempList = new ArrayList<>();

        for (Country c :
             myList)
        {
            if (datest.test(c))
            {
                tempList.add(c);
            }
        }

        return tempList;
    }

    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCompanies ()
    {
        List<Country> myList = new ArrayList<>();
        comprepo.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> listByFirstChar (@PathVariable char letter)
    {
        List<Country> myList = new ArrayList<>();
        comprepo.findAll().iterator().forEachRemaining(myList::add);
        List<Country> returnList = findCountries(myList, c -> c.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter));

        for (Country c :
            returnList)
        {
            System.out.println(c);
        }

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @GetMapping(value = "/population/total", produces = {"application/json"})
    public ResponseEntity<?> getTotalPopulation ()
    {
        long totalpopulation = 0;
        List<Country> populationList = new ArrayList<>();
        comprepo.findAll().iterator().forEachRemaining(populationList::add);
        for (Country c :
            populationList)
        {
            totalpopulation =+ totalpopulation + (long) c.getPopulation();
        }

        return new ResponseEntity<>("The Total Population is : " + totalpopulation, HttpStatus.OK);
    }

    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getMinPopulation ()
    {
        List<Country> minPopulationList = new ArrayList<>();
        comprepo.findAll().iterator().forEachRemaining(minPopulationList::add);
        minPopulationList.sort((c1, c2) -> (int) c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(minPopulationList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxPopulation()
    {
        List<Country> maxPopulationList = new ArrayList<>();
        comprepo.findAll().iterator().forEachRemaining(maxPopulationList::add);
        maxPopulationList.sort((c1, c2) -> (int) c2.getPopulation() - c1.getPopulation());
        return new ResponseEntity<>(maxPopulationList.get(0), HttpStatus.OK);
    }

}
