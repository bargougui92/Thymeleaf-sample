package com.petProjects.ThymeleafSample.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailValidator.class) //this is the class that will contains the business rules ma3enaha t7adid wadhifit l annotation
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE }) //it will be applied on types, fields and annotations
@Retention(RetentionPolicy.RUNTIME) //keep it for the runtime then destroy it
@Documented
public @interface ValidEmail {
    //these are the annotation parameters
    String message() default "Invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}