import { Layout, Menu, Icon } from 'antd';
import React from 'react';
const { Header, Sider, Content } = Layout;

class SiderDemo extends React.Component {
    state = {
        collapsed: false,
    };

    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }

    render() {
        return (
            <Layout>
                <Sider
                    trigger={null}
                    collapsible
                    collapsed={this.state.collapsed}
                >
                    <div className="logo" />
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                        <Menu.Item key="1">
                            <Icon type="home" theme="twoTone" />
                            <span>ElasticSearch</span>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Icon type="tag" theme="twoTone" />
                            <span>Introduction</span>
                        </Menu.Item>
                    </Menu>
                </Sider>
                <Layout>
                    <Header style={{ background: '#fff', padding: 0 }}>
                        <Icon
                            className="trigger"
                            type={this.state.collapsed ? 'right-circle' : 'left-circle'}
                            theme="twoTone"
                            onClick={this.toggle}
                            style={{ fontSize: '30px', color: '#08c' }}
                        />
                    </Header>
                    <Content style={{
                        margin: '24px 16px', padding: 24, background: '#fff', minHeight: window.innerHeight,
                    }}
                    >
                        Content
                    </Content>
                </Layout>
            </Layout>
        );
    }
}


export default SiderDemo;