package org.afrivera.pooclasesabstractas.form;

import org.afrivera.pooclasesabstractas.form.elementos.ElementoForm;
import org.afrivera.pooclasesabstractas.form.elementos.InputForm;
import org.afrivera.pooclasesabstractas.form.elementos.SelectForm;
import org.afrivera.pooclasesabstractas.form.elementos.TextAreaForm;
import org.afrivera.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
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
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2", "Python"));
        lenguaje.addOpcion(new Opcion("3", "JavaScript"));
        lenguaje.addOpcion(new Opcion("4", "TipeScript"));
        lenguaje.addOpcion(new Opcion("5", "PHP"));

        userName.setValor("john.doe");
        password.setValor("abc123");
        email.setValor("jhon.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... mas de 7 años de experiencia ....");
        java.setSelected(true);

        List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(userName);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
    }
}
