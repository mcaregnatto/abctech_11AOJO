package br.com.fiap.abctechapi.service;


import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;

import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDto;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class OrderServiceTest {

    @MockBean
    private AssistanceRepository assistanceRepository;
    @MockBean
    private OrderRepository orderRepository;

    private OrderService orderService;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(assistanceRepository,orderRepository);
        Mockito.when(assistanceRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Assistance(1L, "Teste", "Teste Description")));
    }

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testOrderDtoValidation() {
        OrderDto orderDto = new OrderDto(null, null, null, null);

        Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
        assertEquals(2, violations.size());

        for (ConstraintViolation<OrderDto> violation : violations) {
            assertTrue(violation.getPropertyPath().toString().equals("operatorId") || violation.getPropertyPath().toString().equals("services"));
        }
    }

    @Test
    public void testOrderDtoAttributes() {
        Long operatorId = 1234L;
        List<Long> services = Arrays.asList(1L, 2L, 3L);
        OrderLocationDto start = new OrderLocationDto("Rua A", "123", "São Paulo", "SP", "Brasil");
        OrderLocationDto end = new OrderLocationDto("Rua B", "456", "São Paulo", "SP", "Brasil");

        OrderDto orderDto = new OrderDto(operatorId, services, start, end);

        assertEquals(operatorId, orderDto.getOperatorId());
        assertEquals(services, orderDto.getServices());
        assertEquals(start, orderDto.getStart());
        assertEquals(end, orderDto.getEnd());
    }

    //minimum assistencias > 0
    @Test
    public void create_order_error_min_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    //maximo assistencias <= 15
    @Test
    public void create_order_error_max_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L, 3L, 4L, 5L,6L, 7L, 1L,2L)));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    //cenario order (min)
    @Test
    public void create_order_success(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assistance assistance = new Assistance(1L, "Test", "Test Description");
        Mockito.when(assistanceRepository.findById(Mockito.any())).thenReturn(Optional.of(assistance));
        newOrder.setAssistances(List.of(assistance));
        Assertions.assertDoesNotThrow(() -> orderService.saveOrder(newOrder, List.of(1L)));
        Mockito.verify(orderRepository, Mockito.times(1)).save(newOrder);
    }
    //cenario order (max)
    @Test
    public void create_order_success_max_assist(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assistance assistance = new Assistance(1L, "Test", "Test Description");
        Mockito.when(assistanceRepository.findById(Mockito.any())).thenReturn(Optional.of(assistance));
        newOrder.setAssistances(List.of(assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance, assistance));
        Assertions.assertDoesNotThrow(() -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L, 14L, 15L)));
        Mockito.verify(orderRepository, Mockito.times(1)).save(newOrder);
    }










}
