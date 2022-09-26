package br.com.alura.school.course;

import br.com.alura.school.support.validation.Unique;
import br.com.alura.school.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Unique(entity = Course.class, field = "code")
    @Size(max=10)
    @NotBlank
    @Column(nullable = false)
    private String code;

    @Size(max=30)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String title;

    @Unique(entity = User.class, field = "username")
    @Size(max=30)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String authorUsername;

    @Deprecated
    protected Section(){}

    Section(String code, String title, String authorUsername){
        this.code = code;
        this.title = title;
        this.authorUsername = authorUsername;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }
}
