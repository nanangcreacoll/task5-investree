package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
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

    @PostMapping("/updateStatus")
    public ResponseEntity<Map> updateStatus(@RequestBody Transaksi objModel) {
        Map status = service.updateStatus(objModel);
        return new ResponseEntity<Map>(status, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Transaksi> getList(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam(required = false) String status
    ) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Transaksi> list = null;
        if (status != null) {
            list = transaksiRepository.getByLikeStatus("%"+status+"%", show_data);
        } else {
            list = transaksiRepository.getAll(show_data);
        }
        return new ResponseEntity<Transaksi>((Transaksi) list, new HttpHeaders(), HttpStatus.OK);
    }
}
