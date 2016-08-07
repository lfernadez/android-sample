package py.com.sample.demo.utils;

import java.util.Random;

import py.com.sample.demo.R;

/**
 * Created by Luis on 8/6/2016.
 */
public class Bus {

    private int imageResoureId;
    private String horario;
    private String precio;
    private String empresa;

    public int getImageResoureId() {
        return imageResoureId;
    }

    public void setImageResoureId(int imageResoureId) {
        this.imageResoureId = imageResoureId;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
