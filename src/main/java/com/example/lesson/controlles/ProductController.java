package com.example.lesson.controlles;

import com.example.lesson.models.Product;
import com.example.lesson.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

   // @GetMapping("/example") выглядит значительно проще и понятнее,
   // чем более громоздкое @RequestMapping(value = "/example", method = RequestMethod.GET),
   // что повышает читаемость кода.

   // У аннотации @RequestMapping можно задать следующие параметры:
   // value — для указания адреса;
   //method — определяет метод доступа;
   //consumes — определяет тип содержимого тела запроса;
   //produces — определяет формат возвращаемого методом значения;
   //params — позволяет отфильтровать запросы по наличию или отсутствию определённого параметра в запросе или по его значению;
   //headers — позволяет отфильтровать запросы по наличию или отсутствию определённого заголовка в запросе или по его значению.

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }


    @PostMapping("/product/create") // метод POST предназначен для отправки данных на сервер
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
