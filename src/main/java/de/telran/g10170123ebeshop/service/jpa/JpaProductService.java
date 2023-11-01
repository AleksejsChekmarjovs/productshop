package de.telran.g10170123ebeshop.service.jpa;

import de.telran.g10170123ebeshop.domain.entity.interfaces.Product;
import de.telran.g10170123ebeshop.domain.entity.jpa.JpaProduct;
import de.telran.g10170123ebeshop.domain.entity.jpa.Task;
import de.telran.g10170123ebeshop.repository.jpa.JpaProductRepository;
import de.telran.g10170123ebeshop.repository.jpa.TaskRepository;
import de.telran.g10170123ebeshop.scheduler.ScheduleExecutor;
import de.telran.g10170123ebeshop.service.interfaces.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaProductService implements ProductService {

   private static final Logger LOGGER = LogManager.getLogger(JpaProductService.class);

@Autowired
    private JpaProductRepository repository;
@Autowired
private TaskRepository taskRepository;


    @Override
    public List<Product> getAll() {
        Task task = new Task("Task sheduled after getting all products");
    taskRepository.save(task);
        ScheduleExecutor.executeTask(task);
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Product getById(int id) {
//        LOGGER.log(Level.INFO, String.format("Vizvan metod GETBYID s paramtropm %d", id));
//        LOGGER.log(Level.WARN, String.format("Vizvan metod GETBYID s paramtropm %d", id));
//        LOGGER.log(Level.ERROR, String.format("Vizvan metod GETBYID s paramtropm %d", id));

        LOGGER.info("Vizvan metod GETBYID s paramtropm %d", id);
        LOGGER.warn("Vizvan metod GETBYID s paramtropm %d", id);
        LOGGER.error("Vizvan metod GETBYID s paramtropm %d", id);
        
        return repository.findById(id).orElse(null);
    }

    @Override
    public void addProduct(Product product) {

        product = repository.save(new JpaProduct(0, product.getName(), getAveragePrice()));

    }

    @Override
    public void deleteById(int id) {
        if (id < 1){
            throw  new IllegalArgumentException("ID ne mozet bitj menjshe 1");
        }
        repository.deleteById(id);

    }

    @Override
    public int getCount() {
        return (int)repository.count();
    }

    @Override
    public double getTotalPrice() {
        return repository.getTotalPrice();
    }

    @Override
    public double getAveragePrice() {
        return repository.getAveragePrice();
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);

    }
}
