package tiscon1.controller;

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
import tiscon1.form.AccountRegisterForm;
import tiscon1.form.LoginForm;
import tiscon1.model.Customer;
import tiscon1.model.UserPrincipal;
import tiscon1.repository.CustomerRepository;

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
            session.setAttribute("principal", new UserPrincipal(customer.getName()));
        }
        return "redirect:/my/account?id=";
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
        System.out.println(customer);
        customerRepository.save(customer);
        UserPrincipal principal = new UserPrincipal(form.getName());
        session.setAttribute("principal", principal);
        return "redirect:/my/account?id=" + customer.getId();
    }

    @RequestMapping("/my/account")
    public String mypage(@RequestParam("id") Long customerId,
                         @ModelAttribute("principal")UserPrincipal principal,
                         Model model) {
        if (customerRepository.exists(customerId)) {
            Customer customer = customerRepository.findOne(customerId);
            model.addAttribute("customer", customer);
            return "customerAccount";
        } else {
            return "error";
        }
    }
}
