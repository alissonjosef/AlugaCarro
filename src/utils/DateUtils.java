package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /** Metodo resposavel por retornar a diferente de dias entre datas*/
    public int diasEntreDatas(Date dataInicio, Date dataFim){
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.setTime(dataInicio);

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.setTime(dataFim);

        int diferenca = dataFinal.get(Calendar.YEAR) - dataInicial.get(Calendar.YEAR);

        if (dataFinal.get(Calendar.MONTH) < dataInicial.get(Calendar.MONTH)) {
            diferenca--;
        }
        else
        {
            if (dataFinal.get(Calendar.MONTH) == dataInicial.get(Calendar.MONTH) && dataFinal.get(Calendar.DAY_OF_MONTH) < dataInicial.get(Calendar.DAY_OF_MONTH)) {
                diferenca--;
            }
        }

        return diferenca;
    }
}
