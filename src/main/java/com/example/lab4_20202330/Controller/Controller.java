package com.example.lab4_20202330.Controller;

import com.example.lab4_20202330.Entity.Reserva;
import com.example.lab4_20202330.Entity.User;
import com.example.lab4_20202330.Entity.Vuelo;
import com.example.lab4_20202330.Repository.ReservaRepository;
import com.example.lab4_20202330.Repository.UserRepository;
import com.example.lab4_20202330.Repository.VueloRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    final UserRepository userRepository;
    final VueloRepository vueloRepository;
    final ReservaRepository reservaRepository;

    public Controller(UserRepository userRepository, VueloRepository vueloRepository, ReservaRepository reservaRepository) {
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
        this.reservaRepository = reservaRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "inicio";
    }


    @RequestMapping(value = "/paginaprincipal", method = {RequestMethod.GET,RequestMethod.POST})
    public String iniciarSession(@RequestParam("correo") String email,
                                 @RequestParam("contrasena") String password,
                                 Model model){

        int i=0;
        User user1 = new User();
        List<User> userList = userRepository.findAll();
        for(User u : userList){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
                i=1;
                user1 = u;
                break;
            }
        }
        if (i==1){
            model.addAttribute("listaVuelos", vueloRepository.findAll());
            model.addAttribute("user", user1);
            return "homePage";
        }else {
            return "redirect:/login";
        }
    }

    @GetMapping("/comprar")
    public String comprar(Integer vuelo, Integer user,  RedirectAttributes attr){

        Reserva reserva = new Reserva();
        Vuelo vuelo1 = vueloRepository.findById(vuelo).get();
        User user1 = userRepository.findById(user).get();

        List<Reserva> reservaList = reservaRepository.findAll();
        int i = 0;
        for (Reserva reserva1 : reservaList){
            i++;
        }

        reserva.setIdreserva(i);
        reserva.setPrecio_total(vuelo1.getPrecio());
        reserva.setFecha_reserva(LocalDateTime.now().toString());
        reserva.setEstado_pago("procesado");
        reserva.setUser(user1);
        reserva.setVuelo(vuelo1);
        reservaRepository.save(reserva);

        return "homePage";
    }

}
