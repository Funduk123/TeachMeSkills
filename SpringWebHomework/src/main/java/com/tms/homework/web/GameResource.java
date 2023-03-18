package com.tms.homework.web;

import com.tms.homework.dto.Horse;
import com.tms.homework.dto.Pair;
import com.tms.homework.dto.Rider;
import com.tms.homework.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/*")
public class GameResource {

    private StartService startService;
    private CashService cashService;

    private PairService pairService;

    public GameResource(StartService startService, PairService pairService, CashService cashService) {
        this.startService = startService;
        this.pairService = pairService;
        this.cashService = cashService;
    }

    @GetMapping
    public ModelAndView home() {
        Map<String, Object> model = new HashMap<>();
        model.put("balance", cashService.getCash());
        model.put("pairs", pairService.getAll());
        return new ModelAndView("index", model);
    }

    @PostMapping
    public ModelAndView addPair(@RequestParam String horseName, @RequestParam  String riderName) {

        pairService.addPair(horseName, riderName);

        Map<String, Object> model = new HashMap<>();
        model.put("pairs", pairService.getAll());
        model.put("balance", cashService.getCash());

        return new ModelAndView("index", model);
    }

    @PostMapping("/pairList")
    public ModelAndView start(@RequestParam String bet, @RequestParam String pairNumber) {

        String result = startService.start(pairService.getAll(), Integer.parseInt(bet), Integer.parseInt(pairNumber));

        Map<String, Object> model = new HashMap<>();
        model.put("pairs", pairService.getAll());
        model.put("balance", cashService.getCash());
        model.put("result", result);

        return new ModelAndView("pairList", model);
    }

}