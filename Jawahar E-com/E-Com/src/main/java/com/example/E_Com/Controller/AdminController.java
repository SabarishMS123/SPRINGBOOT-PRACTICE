
package com.example.E_Com.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.E_Com.model.Category;
import com.example.E_Com.model.Product;
import com.example.E_Com.model.ProductOrder;
import com.example.E_Com.service.CategoryService;
import com.example.E_Com.service.OrderService;
import com.example.E_Com.service.ProductService;

import jakarta.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    // ================= ADMIN DASHBOARD =================
    @GetMapping("/Admin/index")
 	@ResponseBody
    public String adminHome() {
   
        return "Admin/index";
    } 
    
//    @GetMapping("/products")
//    public String viewProducts() {
//        return "Admin/products";   // templates/Admin/products.html
//    }
    
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String viewProducts(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            Model model) {

        Page<Product> page = productService.getAllProductsPagination(pageNo, pageSize);

        model.addAttribute("products", page.getContent());
        model.addAttribute("pageNo", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("isFirst", page.isFirst());
        model.addAttribute("isLast", page.isLast());

        return "Admin/products";
    }

    @GetMapping("/users")
    public String viewUsers() {
        return "Admin/users";
    }

//    @GetMapping("/orders")
//    public String viewOrders() {
//        return "Admin/orders";
//    }

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String viewOrders(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            Model model) {

        Page<ProductOrder> page = orderService.getAllOrdersPagination(pageNo, pageSize);
        model.addAttribute("srch", false);
        model.addAttribute("orders", page.getContent());
        model.addAttribute("pageNo", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("isFirst", page.isFirst());
        model.addAttribute("isLast", page.isLast());

        return "Admin/orders";
    }
    
    @GetMapping("/add_admin")
    public String addAdmin() {
        return "Admin/add_admin";
    }

    @GetMapping("/Add_Category")
    public String loadAddCategory(Model m) {

        List<Category> categories = categoryService.getAllCategory();

        m.addAttribute("Categorys", categories);

        return "Admin/Add_Category";
    }

    @GetMapping("/Add_products")
    public String addProduct() {

        return "Admin/Add_Product";
    }

    
    
    
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product,
                              @RequestParam("file") MultipartFile file,
                              HttpSession session) {

        try {
            // 👉 Your save logic here
            // productService.save(product, file);

            session.setAttribute("succMsg", "Product Added Successfully");

        } catch (Exception e) {
            session.setAttribute("errorMsg", "Something went wrong");
        }

        return "success"; // 👉 This will open success.html
    }
    
    
    // ================= SAVE CATEGORY =================
    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category,
                               MultipartFile file,
                               HttpSession session) throws IOException {

        String imageName = file.getOriginalFilename();
        category.setImageName(imageName);

        Boolean existCategory = categoryService.existCategory(category.getName());

        if (existCategory) {

            session.setAttribute("errorMsg", "Category already exists");

        } else {

            Category saveCategory = categoryService.saveCategory(category);

            if (!ObjectUtils.isEmpty(saveCategory)) {

                File saveFile = new ClassPathResource("static/Img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath()
                        + File.separator + "category_img"
                        + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                session.setAttribute("succMsg", "Category Saved Successfully");

            } else {

                session.setAttribute("errorMsg", "Category Not Saved");
            }
        }

        return "redirect:/Admin/addCategory";
    }

    // ================= LOAD EDIT CATEGORY PAGE =================
    @GetMapping("/loadEditCategory/{id}")
    public String loadEditCategory(@PathVariable int id, Model m) {

        Category category = categoryService.getCategoryById(id);

        m.addAttribute("category", category);

        return "Admin/edit_category";
    }

    // ================= UPDATE CATEGORY =================
    @PostMapping("/UpdateCategory")
    public String updateCategory(@ModelAttribute Category category,
                                 MultipartFile file,
                                 HttpSession session) throws IOException {

        Category oldCategory = categoryService.getCategoryById(category.getId());

        String imageName = file.isEmpty()
                ? oldCategory.getImageName()
                : file.getOriginalFilename();

        oldCategory.setName(category.getName());
        oldCategory.setIsActive(category.getIsActive());
        oldCategory.setImageName(imageName);

        Category updateCategory = categoryService.saveCategory(oldCategory);

        if (!ObjectUtils.isEmpty(updateCategory)) {

            if (!file.isEmpty()) {

                File saveFile = new ClassPathResource("static/Img").getFile();

                Path path = Paths.get(saveFile.getAbsolutePath()
                        + File.separator + "category_img"
                        + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }

            session.setAttribute("succMsg", "Category Updated Successfully");

        } else {

            session.setAttribute("errorMsg", "Category Not Updated");
        }

        return "redirect:/Admin/loadEditCategory/" + category.getId();
    }

    // ================= DELETE CATEGORY =================
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, HttpSession session) {

        Boolean deleteCategory = categoryService.deleteCategory(id);

        if (deleteCategory) {

            session.setAttribute("succMsg", "Category Deleted Successfully");

        } else {

            session.setAttribute("errorMsg", "Category Not Deleted");
        }

        return "redirect:/Admin/addCategory";
    }
}

