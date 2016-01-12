package tiscon1.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tiscon1.form.AccountForm;
import tiscon1.form.AccountRegisterForm;
import tiscon1.form.LoginForm;
import tiscon1.model.Customer;
import tiscon1.model.UserPrincipal;
import tiscon1.repository.CustomerRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author kawasima
 */
@Controller
public class AccountController {
    @Autowired
    CustomerRepository customerRepository;

    @ModelAttribute
    AccountRegisterForm setupForm() {
        return new AccountRegisterForm();
    }

    @RequestMapping(value="/login")
    public String login(@Validated LoginForm form, BindingResult bindingResult, HttpSession session) {
        Customer customer = customerRepository.findOne(Specifications
                .where((Specification<Customer>) (root, query, cb) ->
                        cb.equal(root.get("name"), form.getAccount()))
                .and((root, query, cb) ->
                        cb.equal(root.get("password"), form.getPassword())
                ));
        if (customer != null) {
            session.setAttribute("principal", new UserPrincipal(customer.getId(), customer.getName()));
            return "redirect:/my/account";
        } else {
            return "newAccountOrSignIn";
        }
    }

    /**
     * Logout.
     *
     * @param session
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("principal");
        return "redirect:/";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String newAccountOrSignIn() {
        return "newAccountOrSignIn";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String register(@Validated AccountRegisterForm form, BindingResult bindingResult
    , HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "newAccountOrSignIn";
        }
        Customer customer = new Customer(form.getName(), form.getEmail(), form.getPassword());
        customerRepository.save(customer);
        UserPrincipal principal = new UserPrincipal(customer.getId(), form.getName());
        session.setAttribute("principal", principal);
        return "redirect:/my/account";
    }

    @RequestMapping(value="/my/account", method=RequestMethod.GET)
    public String editAccount(Model model, HttpSession session) {
        UserPrincipal principal = (UserPrincipal) session.getAttribute("principal");
        if (customerRepository.exists(principal.getId())) {
            Customer customer = customerRepository.findOne(principal.getId());
            model.addAttribute("customer", customer);
            AccountForm accountForm = new AccountForm();
            BeanUtils.copyProperties(customer, accountForm);
            model.addAttribute("accountForm", accountForm);
            return "customerAccount";
        } else {
            return "error";
        }
    }

    @RequestMapping(value="/my/account", method=RequestMethod.POST)
    public String saveAccount(@Validated AccountForm form, BindingResult bindingResult) {
        return "customerAccount";
    }

    @RequestMapping("/my/orders")
    public String showOrders(@ModelAttribute("principal") UserPrincipal principal) {
        return "customerOrders";
    }

    @RequestMapping("/my/wishlist")
    public String showWishlist(@ModelAttribute("principal") UserPrincipal principal) {
        return "customerWishlist";
    }

}
