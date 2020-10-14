
package ecommerce.prateleira.dao;

public class MPrateleira {
    Integer id;
    Double volume,volumeMaximo;
    String volumeString,volumeMaximoString;

    public String getVolumeString() {
        return volumeString;
    }

    public void setVolumeString(String volumeString) {
        this.volumeString = volumeString;
    }

    public String getVolumeMaximoString() {
        return volumeMaximoString;
    }

    public void setVolumeMaximoString(String volumeMaximoString) {
        this.volumeMaximoString = volumeMaximoString;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getVolumeMaximo() {
        return volumeMaximo;
    }

    public void setVolumeMaximo(Double volumeMaximo) {
        this.volumeMaximo = volumeMaximo;
    }

    

    
    
    
}
