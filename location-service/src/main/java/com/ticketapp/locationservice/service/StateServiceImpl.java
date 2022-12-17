package com.ticketapp.locationservice.service;

import com.ticketapp.locationservice.dao.entity.State;
import com.ticketapp.locationservice.dao.repo.StateRepository;
import com.ticketapp.locationservice.dto.CityResponseDTO;
import com.ticketapp.locationservice.dto.StateRequestDTO;
import com.ticketapp.locationservice.dto.StateResponseDTO;
import com.ticketapp.locationservice.exception.StateNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl extends  AbstractService implements StateService  {
    private final StateRepository repository;

    public StateServiceImpl(ModelMapper modelMapper, StateRepository repository) {
        super(modelMapper);
        this.repository = repository;
    }

    public List<StateResponseDTO> getAllStates(){
        List<State> states  = repository.findAll();
        return states.stream()
                .map(state -> modelMapper.map(state, StateResponseDTO.class))
                .collect(Collectors.toList());
    }


    public StateResponseDTO update(Long id, StateRequestDTO requestDTO) {
        State state = stateById(id);
        state.setName(requestDTO.getName());
        state = repository.save(state);

        return modelMapper.map(state, StateResponseDTO.class);
    }

    public void delete(Long id) {
        repository.delete(stateById(id));
    }

    public StateResponseDTO getStateById(Long id){
        return modelMapper.map(stateById(id), StateResponseDTO.class);
    }


    public StateResponseDTO addState(StateRequestDTO request){
        State state = modelMapper.map(request, State.class);
        state = repository.save(state);
        return modelMapper.map(state, StateResponseDTO.class);
    }


    public List<CityResponseDTO> getCitiesByStateId(Long id) {
        return stateById(id)
                .getCities()
                .stream()
                .map(city -> modelMapper.map(city, CityResponseDTO.class))
                .collect(Collectors.toList());
    }

    private State stateById(Long id) {
        Optional<State> stateOptional =  repository.findById(id);
        if(stateOptional.isEmpty()) throw new StateNotFoundException(String.format("State with id %d not found", id));
        return stateOptional.get();
    }

}