package com.project.springboot_one_to_one_CRUD_uni;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	@Autowired
	StudentRepository srepo;
	

	@RequestMapping("/test")
	public String test()
	{
		return "One to One Unidirectional project";
	}
	
	@PostMapping("/save")
	public String saveData(@RequestBody Student s)
	{
		srepo.save(s);
		return "Data is saved into database";
	}
	
	@GetMapping("/all")
	public List<Student> allData()
	{
		return srepo.findAll();
	}
	
	@PutMapping("/upd/{id}")
	public String update(@RequestBody Student s,@PathVariable int id)
	{
		Student st=srepo.findById(id).get();
		st.setName(s.getName());
		st.setAge(s.getAge());
		st.setGender(s.getGender());
		st.setCourse(s.getCourse());
		st.reservation.setUsername(s.getReservation().getUsername());
		st.reservation.setFormno(s.getReservation().getFormno());
		srepo.save(st);
		return "Data is updated";
	}
	@PatchMapping("/name/upd/{id}")
	public String patchUpdate(@RequestBody Student s,@PathVariable int id)
	{
		Student st=srepo.findById(id).get();
		st.setName(s.getName());
		srepo.save(st);
		return "Data Name is updated";
	}
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable int id)
	{
		srepo.deleteById(id);
		return "Data is deleted";
	}
	
	@GetMapping("/{id}")
	public Optional<Student> byId(@PathVariable int id)
	{
		return srepo.findById(id);
	}
	@GetMapping("/name/{name}")
	public List<Student> nameData(@PathVariable String name)
	{
		return srepo.findByName(name);
	}

	
	/*
	@PostMapping("/save")
    public String saveData(@RequestBody StudentDTO sdto) {
        Student s = new Student();
        s.setName(sdto.getName());
        s.setAge(sdto.getAge());
        s.setGender(sdto.getGender());
        s.setCourse(sdto.getCourse());

        // Assuming Reservation is a nested class or entity within Student
        Reservation reservation = new Reservation();
        reservation.setUsername(sdto.getReservation().getUsername());
        reservation.setFormno(sdto.getReservation().getFormno());

        s.setReservation(reservation); // Assuming there is a setReservation method in Student class

        srepo.save(s);

        return "Data is saved into the database";
    }
	
	@GetMapping("/all")
	public List<StudentDTO> allData()
	{
		return srepo.findAll()
				    .stream()
				    .map(s->{
				    	StudentDTO sdto=new StudentDTO();
				    	sdto.setName(s.getName());
				    	sdto.setAge(s.getAge());
				    	sdto.setGender(s.getGender());
				    	sdto.setCourse(s.getCourse());
				    	
				    	Reservation reservation=new Reservation();
				    	
				    	reservation.setUsername(s.getReservation().getUsername());
				    	reservation.setFormno(s.getReservation().getFormno());
				    	sdto.setReservation(reservation);
				    	return sdto;
				    })
				    .collect(Collectors.toList());
	}
	
	@PutMapping("/upd/{id}")
	public String update(@RequestBody StudentDTO sdto,@PathVariable int id)
	{
		Student s=srepo.findById(id).get();
		 s.setName(sdto.getName());
	        s.setAge(sdto.getAge());
	        s.setGender(sdto.getGender());
	        s.setCourse(sdto.getCourse());

	        // Assuming Reservation is a nested class or entity within Student
	        Reservation reservation = new Reservation();
	        reservation.setUsername(sdto.getReservation().getUsername());
	        reservation.setFormno(sdto.getReservation().getFormno());

	        s.setReservation(reservation); // Assuming there is a setReservation method in Student class

	        srepo.save(s);
	        return "Data is updated";
	}
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable int id)
	{
		srepo.deleteById(id);
		return "Data is deleted";
	}
	*/
}
