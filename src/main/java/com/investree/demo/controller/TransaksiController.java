package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    public TransaksiRepository transaksiRepository;

    @Autowired
    public TransaksiService service;

    @PostMapping("/save")
    public ResponseEntity<Map> save(@RequestBody Transaksi objModel) {
        Map obj = service.save(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update-status")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel) {
        Map status = service.updateStatus(objModel);
        return new ResponseEntity<Map>(status, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Transaksi> list(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String status
    ) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> transaksiPage;
        if (status != null) {
            transaksiPage = transaksiRepository.findByStatusLike("%"+status+"%", show_data);
        } else {
            transaksiPage = transaksiRepository.getList(show_data);
        }
        return new ResponseEntity(transaksiPage, new HttpHeaders(), HttpStatus.OK);
    }
}
