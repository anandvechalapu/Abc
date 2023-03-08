

Controller

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selectingdates")
public class SelectingDatesController {

    @GetMapping
    public String getSelectingDates(){
        return "selectingdates";
    }

}

Service

import java.util.Date;

public interface SelectingDatesService {

    Date selectDate(int month, int year);

}

public class SelectingDatesServiceImpl implements SelectingDatesService {

    @Override
    public Date selectDate(int month, int year) {
        Date date = new Date(year, month, 1);
        return date;
    }

}

Repository

import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectingDatesRepository extends JpaRepository<SelectingDates, Long> {

}