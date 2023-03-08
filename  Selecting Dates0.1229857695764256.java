

Controller:

@Controller
public class DateController {
    
    @Autowired
    private DateService dateService;

    @GetMapping("/select-dates")
    public String selectDates() {
        return "select-dates";
    }

    @PostMapping("/select-dates")
    public String selectDates(@RequestParam("date") LocalDate date,
                              @RequestParam("month") int month,
                              @RequestParam("year") int year,
                              Model model) {
        DateRange dateRange = dateService.getDateRange(date, month, year);
        model.addAttribute("dateRange", dateRange);
        return "select-dates";
    }
    
}

Service:

@Service
public class DateService {

    public DateRange getDateRange(LocalDate date, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, date.getDayOfMonth());
        LocalDate endDate = startDate.plusMonths(1);

        return new DateRange(startDate, endDate);
    }

}

Repository:

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {

}