package br.edu.ifpr.foz.locacao_vhs.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.foz.locacao_vhs.models.Usuario;
import br.edu.ifpr.foz.locacao_vhs.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
