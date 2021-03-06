package fr.vours.smartproj.controller

import fr.vours.smartproj.model.Proj
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import fr.vours.smartproj.services.proj.ProjService
import java.util.*

@CrossOrigin(origins = ["*"])//"http://localhost:8081", "http://192.168.1.6:8081", "192.168.1.48:8081", "http://192.168.1.32"])
@RestController//declare this class as rest controller able to catch http request
@RequestMapping("proj")//controller root path
class ProjController(private val projService: ProjService) {//injects projService by constructor


    @GetMapping
    fun getAll(pageable: Pageable): Page<Proj> = projService.getAll(pageable)


    @GetMapping("{isbn}")
    fun getById(@PathVariable isbn: String): Optional<Proj> = projService.getById(isbn)


//    @GetMapping("/byName/{regex}") fun getByName(@PathVariable regex:String):List<Proj> = projService.findByNameRegex(regex)


    @PostMapping
    fun insert(): Proj = projService.insert(Proj())

    @PutMapping("/{id}")
    fun update(@PathVariable(name = "id") id: String, @RequestBody proj: Proj): Proj = projService.update(id, proj)


    @DeleteMapping("{isbn}")
    fun deleteByIsbn(@PathVariable isbn: String): Optional<Proj> = projService.deleteById(isbn)
}