package local.heftyb.countries.repositories;

import local.heftyb.countries.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long>
{
}
