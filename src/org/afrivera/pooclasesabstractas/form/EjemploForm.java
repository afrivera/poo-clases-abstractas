package org.afrivera.pooclasesabstractas.form;

import org.afrivera.pooclasesabstractas.form.elementos.*;
import org.afrivera.pooclasesabstractas.form.elementos.select.Opcion;

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
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
            .addOpcion(new Opcion("2", "Python"))
            .addOpcion(new Opcion("3", "JavaScript").setSelected())
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

        userName.setValor("john.doe");
        password.setValor("abc123");
        email.setValor("jhon.doe@correo.com");
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
    }
}
