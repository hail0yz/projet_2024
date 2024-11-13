/*-------------------------/
/Projet Vidéoclub 
/
/-------------------------*/

package org.tp.data;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String Description;
   // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.title = name;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
