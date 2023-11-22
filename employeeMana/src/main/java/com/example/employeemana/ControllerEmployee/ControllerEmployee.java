package com.example.employeemana.ControllerEmployee;

import com.example.employeemana.ModleEmployee.ModleEmployee;
import com.example.employeemana.ValidationEmployee.ValidationEmployee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class ControllerEmployee {
    private final ValidationEmployee validationEmployee;

    @GetMapping("/get")
    public ResponseEntity getArticle() {
        ArrayList<ModleEmployee> m1 = validationEmployee.getMod();
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }
    @PostMapping("/add")
    public ResponseEntity addmod(@RequestBody @Valid ModleEmployee modleEmployee, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        validationEmployee.addMod(modleEmployee);
        return ResponseEntity.status(HttpStatus.OK).body("employee added");

    }
    @PutMapping ("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable String id,@RequestBody @Valid ModleEmployee modleEmployee, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdate =validationEmployee.UpdateModel(id,modleEmployee);
        if (isUpdate) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee update");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable String id) {
        boolean isDelete = validationEmployee.deleteModel(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("blog deleted");

        }
        return ResponseEntity.status(400).body("wrong id");

    }
    @GetMapping("/pus/{position}")
    public ArrayList<ModleEmployee> position(@PathVariable String position){
        ArrayList<ModleEmployee> v =validationEmployee.searchModel(position);
        return v;
    }
    @GetMapping("/age/{min}/{max}")
public  ArrayList<ModleEmployee> Range(@PathVariable int  min ,@PathVariable int  max){
    ArrayList<ModleEmployee> ag = validationEmployee.getRange(min,max);
    return ag;
}
@GetMapping ("/noannu/{id}")
public ArrayList<ModleEmployee> getNoAnnualLeave(@PathVariable String id){
    ArrayList<ModleEmployee> gna = validationEmployee.getAnnul(id);
    return gna;
}
public ResponseEntity getNoAnnual(@PathVariable String id){
    ArrayList<ModleEmployee> ga =validationEmployee.getAnnul(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
}
    public ResponseEntity getPromote(@PathVariable String id){
        ArrayList<ModleEmployee> gp = validationEmployee.promote(id);
        return ResponseEntity.status(HttpStatus.OK).body("");

    }

}
