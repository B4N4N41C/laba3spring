package ru.mochalin.laba31.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mochalin.laba31.Model.Buyer;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> {

}
