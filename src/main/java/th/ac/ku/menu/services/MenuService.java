package th.ac.ku.menu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.menu.models.Menu;
import th.ac.ku.menu.repositories.MenuRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu create(Menu menu) {
        Menu record = menuRepository.save(menu);
        return record;
    }

    public Menu getMenuById(UUID id) {
        return menuRepository.findById(id).get();
    }

    public Menu update(Menu requestBody) {
        UUID id = requestBody.getId();
        Menu record = menuRepository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setCategory(requestBody.getCategory());

        record = menuRepository.save(record);
        return record;
    }

    public Menu delete(UUID id) {
        Menu record = menuRepository.findById(id).get();
        menuRepository.deleteById(id);
        return record;
    }

    public Menu getMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    public List<Menu> getMenuByCategory(String category) {
        return menuRepository.findByCategory(category);
    }

}
