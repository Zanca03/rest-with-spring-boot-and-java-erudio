package dev.carlosezpereira.restwithspringbootandjavaerudio.controller;

import dev.carlosezpereira.restwithspringbootandjavaerudio.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import static dev.carlosezpereira.restwithspringbootandjavaerudio.util.NumericUtilities.isNumeric;
import static dev.carlosezpereira.restwithspringbootandjavaerudio.util.NumericUtilities.convertToDouble;
import static dev.carlosezpereira.restwithspringbootandjavaerudio.util.Math.*;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
                    method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
                      throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        return addition(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        return subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multi(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        return multiplication(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        if(numberTwo.equals("0")){
            throw new ResourceNotFoundException("The divisor can't be zero!");
        }
        return division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/median/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double median(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        return median2(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/square/{numberOne}",
            method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne)
            throws Exception{
        if(!isNumeric(numberOne)){
            throw new ResourceNotFoundException("Please, set a numeric value!");
        }
        return square(convertToDouble(numberOne));
    }
}
