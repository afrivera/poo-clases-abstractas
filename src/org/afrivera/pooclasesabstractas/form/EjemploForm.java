package org.afrivera.pooclasesabstractas.form;

import org.afrivera.pooclasesabstractas.form.elementos.*;
import org.afrivera.pooclasesabstractas.form.elementos.select.Opcion;
import org.afrivera.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {
        // no se puede instanciar una clase abstracta
        // esto sería una clase anonima
//        ElementoForm el = new ElementoForm() {
//            @Override
//            public String dibujarHtml() {
//                return null;
//            }
//        };
        InputForm userName = new InputForm("username");
        userName.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNulo());

        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
            .addOpcion(new Opcion("2", "Python").setSelected())
            .addOpcion(new Opcion("3", "JavaScript"))
            .addOpcion(new Opcion("4", "TipeScript"))
            .addOpcion(new Opcion("5", "PHP"));

        // clase anonima para ejecutar una unica vez
        ElementoForm saludar = new ElementoForm("Saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre +"' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado");

        userName.setValor("afrivera");
        password.setValor("abc123");
        email.setValor("afrivera@correo.com");
        edad.setValor("28");
        experiencia.setValor("... mas de 7 años de experiencia ....");
        // java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(userName, password, email, edad, experiencia, lenguaje, saludar);
        // con la linea de arriba se simplificaria lo de abajo
//        elementos.add(userName);
//        elementos.add(password);
//        elementos.add(email);
//        elementos.add(edad);
//        elementos.add(experiencia);
//        elementos.add(lenguaje);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

        // otra forma de recorrer el List
        elementos.forEach( e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e ->{
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });
    }
}
