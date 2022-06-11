package com.clientsapi.usecases;
import com.clientsapi.entities.Client;
import com.clientsapi.persistence_component.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository repository;

    @InjectMocks
    private ClientServiceImpl subject;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void shouldFindByIdCorrectly(){
        Optional<Client> clientOptional = Optional.of(Client.builder().build());

        when(repository.findById(1)).thenReturn(clientOptional);

        assertEquals(clientOptional,subject.findById(1));

        verify(repository).findById(1);
    }

    @Test
    public void shouldFindAllCorrectly(){
        List<Client> clientList = Collections.singletonList(Client.builder().clientId(1).build());

        when(repository.findAll()).thenReturn(clientList);

        assertEquals(clientList, subject.findAll());

        verify(repository).findAll();
    }

    @Test
    public void shouldSaveCorrectly(){
        Client client = Client.builder().clientId(1).build();

        when(repository.save(client)).thenReturn(client);

        assertEquals(client, subject.save(client));

        verify(repository).save(client);
    }

    @Test
    public void shouldDeleteCorrectly(){
        Integer id = 1;
        Client client = Client.builder().clientId(1).build();

        when(repository.findById(id)).thenReturn(Optional.of(client));
        doNothing().when(repository).delete(client);

        assertTrue(subject.delete(id));
    }
}