package ChamadasLeitos.chamadas.Service;

import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Repository.R_Interruptor;
import ChamadasLeitos.chamadas.Repository.R_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class S_Interruptor {
    @Autowired
    private static R_Interruptor r_interruptor;

    @Autowired
    private static R_Registro r_registro;

    public S_Interruptor(R_Interruptor r_interruptor, R_Registro r_registro) {
        this.r_interruptor = r_interruptor;
        this.r_registro = r_registro;
    }

    public List<M_Interruptor> listarInterruptores() {
        return r_interruptor.findAll();
    }

//    public static void alterarEstado(String interruptorNome) {
//        Optional<M_Interruptor> interruptorOpt = r_interruptor.findByInterruptor(interruptorNome);
//
//        if (interruptorOpt.isPresent()) {
//            M_Interruptor m_interruptor = interruptorOpt.get();
//            boolean novoEstado = !m_interruptor.isEstado();
//
//            if (m_interruptor.isEstado() != novoEstado) {
//                m_interruptor.setEstado(novoEstado);
//                r_interruptor.save(m_interruptor);
//
//                M_Registro m_registro = new M_Registro();
//                m_registro.setAcao(novoEstado ? "Ligado" : "Desligado");
//                m_registro.setData_hora(LocalDateTime.now());
//                m_registro.setNome(m_interruptor.getInterruptor());
//                r_registro.save(m_registro);
//            }
//        }
//    }


    public static void alterarEstado(String interruptorNome) {
        Optional<M_Interruptor> interruptorOpt = r_interruptor.findByInterruptor(interruptorNome);

        if (interruptorOpt.isPresent()) {
            M_Interruptor m_interruptor = interruptorOpt.get();
            m_interruptor.setEstado(!m_interruptor.isEstado());
            r_interruptor.save(m_interruptor);

            M_Registro m_registro = new M_Registro();
            m_registro.setAcao(m_interruptor.isEstado() ? "Ligado" : "Desligado");
            m_registro.setData_hora(LocalDateTime.now());
            m_registro.setNome(m_interruptor.getInterruptor());
            r_registro.save(m_registro);
        }
    }




//        public void iniciarLeituraSerial() {
//            // Abra a porta serial correspondente ao Arduino
//            SerialPort arduinoPort = SerialPort.getCommPort("dev/cu.usbserial-1120");
//            if (arduinoPort.openPort()) {
//                System.out.println("Porta serial do Arduino aberta com sucesso.");
//
//                // Aguarde um curto período para garantir que o Arduino tenha tempo de inicializar
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                // Inicie uma thread para leitura assíncrona da porta serial
//                Thread threadLeitura = new Thread(() -> {
//                    while (true) {
//                        byte[] buffer = new byte[256];
//                        int bytesRead = arduinoPort.readBytes(buffer, buffer.length);
//
//                        if (bytesRead > 0) {
//                            String resposta = new String(buffer, 0, bytesRead);
//                            processarRespostaArduino(resposta);
//                        }
//
//                        // Aguarde um curto período antes da próxima leitura
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                threadLeitura.start();
//            } else {
//                System.out.println("Erro ao abrir porta serial do Arduino.");
//            }
//        }
//
//        private void processarRespostaArduino(String resposta) {
//            System.out.println("Resposta do Arduino: " + resposta);
//
//            // Implemente a lógica para processar a resposta do Arduino aqui
//            // Por exemplo, atualizar o estado do interruptor com base na resposta
//        }
//
//        public static void main(String[] args) {
//            ArduinoCommunication arduinoCommunication = new ArduinoCommunication();
//            arduinoCommunication.iniciarLeituraSerial();
//        }
//    }

}


